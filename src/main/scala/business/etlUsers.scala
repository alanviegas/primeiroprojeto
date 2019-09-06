package br.com.alan.primeiroprojeto.business

import br.com.alan.primeiroprojeto.objects._
import br.com.alan.primeiroprojeto.dao.usersDao
import br.com.alan.primeiroprojeto.objects.context.CSVContext
import org.apache.spark.sql.{DataFrame, SaveMode}
import org.apache.spark.sql.functions._
import org.apache.spark.SparkContext
import java.time.Instant
import org.apache.log4j.{Level, Logger}
import com.typesafe.config.ConfigFactory

class etlUsers(sc: SparkContext, CSVCtx: CSVContext, paramAge: Int, log: Logger) {

  val configManager = ConfigFactory.load()

  def current_timestamp:Long = Instant.now().getEpochSecond*1000

  def extractData(): DataFrame = {
    log.info("[*] Instanciando users")
    val appliedUsersDao = usersDao.apply(sc, CSVCtx, paramAge, log)

    log.info("[*] Carregando dados de users")
    val appliedUsers = appliedUsersDao.getUsedFields().repartition(configManager.getString(s"spark.numrepartitions").toInt)

    if(log.getLevel() == Level.DEBUG) {
      log.debug(s"[*] appliedUsers count: ${appliedUsers.count()}")
      log.debug(s"[*] appliedUsers show: ${appliedUsers.show(1,false)}")
    }
    appliedUsers
  }

  def transformData(df: DataFrame): DataFrame = {

    log.info("[*] Renomeando colunas")
    df.withColumn("codigoUsuario", col(user.USER_ID))
      .withColumn("Idade", col(user.AGE))
      .withColumn("Ocupacao", col(user.OCCUPATION))
      .withColumn("Cep", col(user.ZIP_CODE))
      .withColumn("Genero", col(user.GENRE_ID))
      .withColumn("Timestamp", col(data.TIMESTAMP))
      .withColumn("Item_Id",  col(data.ITEM_ID))
      .withColumn("Rating",col(data.RATING))
      .distinct()
  }

  /*
    def generateCollectionFields(df: DataFrame): DataFrame = {
      df.groupBy(df(Company.CNPJ), df(Company.RZ))
        .agg(collect_set(df(Company.CYCLE)).alias(Company_Agg.CYCLES), collect_set(df(Company.PLAN)).alias(Company_Agg.PLANS))
        .distinct()
  }
  */

  def loadToParquet(df: DataFrame): Unit = {

    log.info("[*] Starting to save ")

    log.info("[*] get date on format epoch")
    val dateLastUpdated = current_timestamp

    val dfFinal = df.withColumn("dt_insert", lit(dateLastUpdated))

    dfFinal.select("codigoUsuario", "Idade", "Ocupacao", "Cep", "Genero",
                   "Timestamp", "Item_Id", "Rating", "dt_insert")
           .write.mode(SaveMode.Append).format("parquet").save(configManager.getString(s"Path.Users"))

  }

}
