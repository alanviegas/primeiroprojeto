package br.com.alan.primeiroprojeto.objects.context


import org.apache.spark.SparkContext
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext

class CSVContext (sqlCtx: SQLContext){

  def getCSV(file: String): DataFrame= {
    val dfFile = sqlCtx.read.option("delimiter","|").csv(file)
    dfFile
  }
}
