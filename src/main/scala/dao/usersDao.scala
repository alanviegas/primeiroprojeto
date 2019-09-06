package br.com.alan.primeiroprojeto.dao

import br.com.alan.primeiroprojeto.objects.{data, genre, user}
import br.com.alan.primeiroprojeto.objects.context.CSVContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType
import org.apache.log4j.{Level, Logger}
import com.typesafe.config.ConfigFactory

class usersDao(sc: SparkContext, CSVctx: CSVContext, paramAge: Int, log: Logger) {

  val configManager = ConfigFactory.load()
  val pathSource = configManager.getString(s"Path.SourceDir")

  def selectTableData: DataFrame = CSVctx.getCSV(pathSource + data.TABLE)

  def selectTableGenre: DataFrame = CSVctx.getCSV(pathSource + genre.TABLE)

  def selectTableUser: DataFrame = CSVctx.getCSV(pathSource + user.TABLE)

  def whereAgeUser(df: DataFrame): DataFrame = {
    log.info("[*] aplicando filtro" + user.AGE + ">=" + paramAge)

    df.filter(col(user.AGE).cast(IntegerType) >= lit(paramAge))
  }

  def getUsedFields(): DataFrame = {

    log.info("[*] select de usuarios: ")
    val userFilter = whereAgeUser(user.SELECT_DATA(selectTableUser.toDF(user.USER_ID,
                                                                        user.AGE,
                                                                        user.GENRE_ID,
                                                                        user.OCCUPATION,
                                                                        user.ZIP_CODE)))
                                      .select(
                                        col(user.USER_ID),
                                        col(user.GENRE_ID),
                                        col(user.AGE),
                                        col(user.OCCUPATION),
                                        col(user.ZIP_CODE))

    if(log.getLevel() == Level.DEBUG){
      log.debug(s"[*] userFilter count: ${userFilter.count()}")
      log.debug(s"[*] userFilter show: ${userFilter.show(1,false)}")
    }

    log.info("[*] select de dados:")
    val dataFilter = data.SELECT_DATA(selectTableData.toDF(data.USER_ID,
                                                           data.ITEM_ID,
                                                           data.RATING,
                                                           data.TIMESTAMP))
                                .select(
                                  col(data.USER_ID),
                                  col(data.ITEM_ID),
                                  col(data.TIMESTAMP),
                                  col(data.RATING))

    if(log.getLevel() == Level.DEBUG){
      log.debug(s"[*] dataFilter count: ${dataFilter.count()}")
      log.debug(s"[*] dataFilter show: ${dataFilter.show(1,false)}")

    }

    log.info("[*] select de generos: ")
    val genreFilter = genre.SELECT_DATA(selectTableGenre.toDF(genre.GENRE_NAME,
                                                              genre.GENRE_ID))
                          .select(
                            col(genre.GENRE_ID),
                            col(genre.GENRE_NAME))


    userFilter.join(dataFilter, Seq(user.USER_ID), "inner")
       .select(
        col(user.USER_ID),
        col(user.AGE),
        col(user.OCCUPATION),
        col(user.ZIP_CODE),
        col(user.GENRE_ID),
        col(data.ITEM_ID),
        col(data.TIMESTAMP),
        col(data.RATING)).limit(1)

  }

}

object usersDao {
    def apply(sc: SparkContext, CSVctx: CSVContext, paramAge: Int, log: Logger): usersDao = new usersDao(sc, CSVctx, paramAge, log)
}