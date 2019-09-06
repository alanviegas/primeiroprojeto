package br.com.alan.primeiroprojeto.objects

import org.apache.spark.sql.DataFrame

object genre {

  val TABLE = "u.genre"

  val GENRE_NAME = "GenreName"
  val GENRE_ID = "GenreId"

  def SELECT_DATA(table: DataFrame): DataFrame = {
    table.select(
      GENRE_NAME,
      GENRE_ID)
  }

}
