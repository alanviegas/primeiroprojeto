package br.com.alan.primeiroprojeto.objects

import org.apache.spark.sql.DataFrame

object user {
  val TABLE = "u.user"

  val USER_ID = "UserId"
  val AGE = "Age"
  val GENRE_ID = "GenreId"
  val OCCUPATION = "Occupation"
  val ZIP_CODE = "ZipCode"

  def SELECT_DATA(table: DataFrame): DataFrame = {
      table.select(
        USER_ID,
        AGE,
        GENRE_ID,
        OCCUPATION,
        ZIP_CODE)
  }

}
