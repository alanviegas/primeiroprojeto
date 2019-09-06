package br.com.alan.primeiroprojeto.business

// standard library imports
import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSuite
import org.apache.spark.sql.SQLContext
import br.com.alan.primeiroprojeto.dao.usersDao
import br.com.alan.primeiroprojeto.objects.context.CSVContext
import org.apache.log4j.{Level, Logger}
import com.typesafe.config.ConfigFactory
import org.apache.spark.{SparkConf, SparkContext}


class teste extends FunSuite with SharedSparkContext {

  val debug = false

  test("[usersDao: Caso de teste 1") {

    val configManager = ConfigFactory.load()

    val log = Logger.getLogger("PrimeiroProjeto")
    log.setLevel(Level.DEBUG)

    val sqlContext = new SQLContext(sc)
    val CSVCtx = new CSVContext(sqlContext)

    val leiturasRadius = sqlContext.createDataFrame(sc.parallelize(mock.leiturasRadius_Data("teste1")), mock.leiturasRadius_Struct)
    val cadastroCliente = sqlContext.createDataFrame(sc.parallelize(mock.cadastroCliente_Data("teste1")), mock.cadastroCliente_Struct)
    val paramAge = 18

    val appliedUsersDao = usersDao.apply(sc, CSVCtx, paramAge, log)

    val result = appliedUsersDao.getUsedFields().repartition(configManager.getString(s"spark.numrepartitions").toInt)

    if (debug) {
      result.printSchema()
      result.show(false)
    }

    val expected = sqlContext.createDataFrame(sc.parallelize(mock.appliedUser_Data("teste1")), mock.appliedUser_Struct)
    if (debug) {
      expected.printSchema()
      expected.show(false)
    }
    assert(result.collect().sameElements(expected.collect()))
  }
}