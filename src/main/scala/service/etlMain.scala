package  br.com.alan.primeiroprojeto.service

import com.typesafe.config.ConfigFactory
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import br.com.alan.primeiroprojeto.business.etlUsers
import br.com.alan.primeiroprojeto.objects.context.CSVContext


/* Passar como parametro o nome do processo e a idade minima do filtro
 *
 * Author: Alan Viegas
*/

object etlMain {

  def dataUsersHandler(sc: SparkContext, CSVCtx: CSVContext, paramAge: Int, log: Logger): Unit = {
    val users = new etlUsers(sc, CSVCtx, paramAge, log)
    users.loadToParquet(users.transformData(users.extractData()))
  }

  def main(args: Array[String]): Unit = {

    val configManager = ConfigFactory.load()

    val log = Logger.getLogger("PrimeiroProjeto")

    val loglevel = configManager.getString(s"log.level")
    loglevel match {
      case "INFO" => log.setLevel(Level.INFO)
      case "DEBUG" => log.setLevel(Level.DEBUG)
      case "WARN" => log.setLevel(Level.WARN)
      case "ERROR" => log.setLevel(Level.ERROR)
      case _ => log.setLevel(Level.INFO)
    }

    log.info(s"[*] Log Level: $loglevel")

    val sparkConf = new SparkConf().set("spark.hadoop.yarn.resourcemanager.hostname", "resourcemanager.fqdn")
                                   .set("spark.hadoop.yarn.resourcemanager.address", "resourcemanager.fqdn:8032")
                                   .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                                   .setAppName("PrimeiroPrograma")

    val sc = new SparkContext(sparkConf)

    //val session = SparkSession(sc)
    val sqlContext = new SQLContext(sc)

    val CSVctx = new CSVContext(sqlContext)

    val paramNameClass = args(0)
    val paramAge = args(1)
    log.info("[*] Age: " + paramAge)
    log.info("[*] Process Type " + paramNameClass)

    val numParamAge = paramAge.toString.toInt

    paramNameClass match {
      case "users" => dataUsersHandler(sc, CSVctx, numParamAge, log)
    }

    log.info("[*] Finished ")
  }

}
