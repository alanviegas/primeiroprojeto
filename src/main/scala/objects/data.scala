package br.com.alan.primeiroprojeto.objects

import org.apache.spark.sql.DataFrame

object data {

  val TABLE = "u.data"

  val USER_ID = "UserId"
  val ITEM_ID = "ItemId"
  val RATING = "Rating"
  val TIMESTAMP = "Timestamp"

  def SELECT_DATA(table: DataFrame): DataFrame = {
      table.select(
        USER_ID,
        ITEM_ID,
        RATING,
        TIMESTAMP)
  }

}


