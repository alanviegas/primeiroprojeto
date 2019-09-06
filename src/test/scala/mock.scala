package br.com.alan.primeiroprojeto.business

import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

object mock {

  //============================
  // Structs
  //============================
  val appliedUser_Struct =
  StructType(
    Seq(
      StructField(name = "UserId", dataType=StringType, nullable=false),
      StructField(name = "Age", dataType=StringType, nullable=false),
      StructField(name = "Occupation", dataType=StringType, nullable=false),
      StructField(name = "Zip_Code", dataType=StringType, nullable=false),
      StructField(name = "Genre_Id", dataType=StringType, nullable=false),
      StructField(name = "Item_Id", dataType=LongType, nullable=false),
      StructField(name = "Timestamp", dataType=LongType, nullable=false),
      StructField(name = "Rating", dataType=StringType, nullable=false)
    )
  )

  val leiturasRadius_Struct =
  StructType(
    Seq(
      StructField(name = "3gpp_imeisv", dataType=StringType, nullable=false),
      StructField(name = "3gpp_user_location_info", dataType=StringType, nullable=false),
      StructField(name = "MSISDN", dataType=StringType, nullable=false),
      StructField(name = "APN", dataType=StringType, nullable=false),
      StructField(name = "acct_status_type", dataType=StringType, nullable=false),
      StructField(name = "acct_input_octets", dataType=LongType, nullable=false),
      StructField(name = "acct_output_octets", dataType=LongType, nullable=false),
      StructField(name = "sessionId", dataType=StringType, nullable=false),
      StructField(name = "timestamp_radius", dataType=LongType, nullable=false),
      StructField(name = "acct_input_gigawords", dataType=IntegerType, nullable=false),
      StructField(name = "acct_output_gigawords", dataType=IntegerType, nullable=false),
      StructField(name = "startDateTime", dataType=LongType, nullable=false)
    )
  )

  val cadastroCliente_Struct =
    StructType(
      Seq(
        StructField(name = "banid", dataType=StringType, nullable=false),
        StructField(name = "MSISDN", dataType=StringType, nullable=false),
        StructField(name = "datamovto", dataType=StringType, nullable=false)
      )
    )

   //============================
  // Data
  //============================

  val appliedUser_Data =
  Map (
    "teste1" ->
    Seq(
      Row("196", "24", "technician", "85711", "M", "242", "881250949", "3")
    )
  )

  val leiturasRadius_Data =
  Map(
    "teste1" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Start"          , 0L, 0L,       "AAAAAAAAAAAAAAAA",  1531908000L, 0, 0,1000L), //18-07-2018 10:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 200L, 100L,   "AAAAAAAAAAAAAAAA",  1531951200L, 0, 0,1000L), //18-07-2018 22:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 400L, 200L,   "AAAAAAAAAAAAAAAA",  1531994400L, 0, 0,1000L), //19-07-2018 10:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 600L, 300L,   "AAAAAAAAAAAAAAAA",  1532012400L, 0, 0,1000L), //19-07-2018 15:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 800L, 400L,   "AAAAAAAAAAAAAAAA",  1532037600L, 0, 0,1000L), //19-07-2018 22:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 1000L, 500L,  "AAAAAAAAAAAAAAAA",  1532080800L, 0, 0,1000L), //20-07-2018 10:00
        Row("","0x0027f4501073c646","5511911111111", "APN TESTE", "Stop"           , 1200L, 600L,  "AAAAAAAAAAAAAAAA",  1532098800L, 0, 0,1000L)  //20-07-2018 15:00
      ),
    "teste2" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511922222222", "APN TESTE", "Start"          , 0L, 0L, "BBBBBBBBBBBBBBBB",  1531994400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511922222222", "APN TESTE", "Interim-Update" , 500L, 500L, "BBBBBBBBBBBBBBBB",  1532012400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511922222222", "APN TESTE", "Stop"           , 1000L, 1000L, "BBBBBBBBBBBBBBBB",  1532037600L, 0, 0,1000L)
      ),
    "teste3" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Start"          , 0L, 0L, "CCCCCCCCCCCCCCCC",  1531908000L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 250L, 125L, "CCCCCCCCCCCCCCCC",  1531951200L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 500L, 250L, "CCCCCCCCCCCCCCCC",  1531994400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511933333333", "APN TESTE", "Stop"           , 1000L, 500L, "CCCCCCCCCCCCCCCC",  1532012400L, 0, 0,1000L)
      ),
    "teste4" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Start"          , 0L, 0L, "DDDDDDDDDDDDDDDD",  1532012400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 250L, 125L, "DDDDDDDDDDDDDDDD",  1532037600L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 500L, 250L, "DDDDDDDDDDDDDDDD",  1532080800L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511933333333", "APN TESTE", "Stop"           , 1000L, 500L, "DDDDDDDDDDDDDDDD",  1532098800L, 0, 0,1000L)
      ),
    "teste5" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Start"          , 0L, 0L, "EEEEEEEEEEEEEEEE", 1531972800L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Interim-Update" , 500L, 250L, "EEEEEEEEEEEEEEEE",  1531994400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511944444444", "APN TESTE", "Stop"           , 1000L, 1000L, "EEEEEEEEEEEEEEEE",  1532030400L, 0, 0,1000L)
      ),
    "teste6" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Start"          , 0L, 0L, "EEEEEEEEEEEEEEEE", 1531972800L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Interim-Update" , 500L, 250L, "EEEEEEEEEEEEEEEE",  1531994400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511944444444", "APN TESTE", "Stop"           , 1000L, 1000L, "EEEEEEEEEEEEEEEE",  1532030400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Start"          , 0L, 0L,       "AAAAAAAAAAAAAAAA",  1531908000L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 200L, 100L,   "AAAAAAAAAAAAAAAA",  1531951200L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 400L, 200L,   "AAAAAAAAAAAAAAAA",  1531994400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 600L, 300L,   "AAAAAAAAAAAAAAAA",  1532012400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 800L, 400L,   "AAAAAAAAAAAAAAAA",  1532037600L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 1000L, 500L,  "AAAAAAAAAAAAAAAA",  1532080800L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511911111111", "APN TESTE", "Stop"           , 1200L, 600L,  "AAAAAAAAAAAAAAAA",  1532098800L, 0, 0,1000L)
      ),
    "teste7" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Start"          , 0L, 0L, "EEEEEEEEEEEEEEEE", 1531972800L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Interim-Update" , 500L, 250L, "EEEEEEEEEEEEEEEE", 1531994400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511944444444", "APN TESTE", "Stop"           , 1000L, 1000L, "EEEEEEEEEEEEEEEE", 1532030400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511966666666", "APN TESTE", "Start"          , 0L, 0L,       "FFFFFFFFFFFFFFFF", 1531994400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511966666666", "APN TESTE", "Interim-Update" , 50L, 50L,   "FFFFFFFFFFFFFFFF", 1531994400L, 0, 0,1000L)
      ),
    "teste8" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Start"          , 0L, 0L,       "AAAAAAAAAAAAAAAA",  1531908000L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 200L, 100L,   "AAAAAAAAAAAAAAAA",  1531951200L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 400L, 200L,   "AAAAAAAAAAAAAAAA",  1531994400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 600L, 300L,   "AAAAAAAAAAAAAAAA",  1532012400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 800L, 400L,   "AAAAAAAAAAAAAAAA",  1532037600L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 1000L, 500L,  "AAAAAAAAAAAAAAAA",  1532080800L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511911111111", "APN TESTE", "Stop"           , 1200L, 600L,  "AAAAAAAAAAAAAAAA",  1532098800L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511922222222", "APN TESTE", "Start"          , 0L, 0L, "BBBBBBBBBBBBBBBB",  1531994400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511922222222", "APN TESTE", "Interim-Update" , 500L, 500L, "BBBBBBBBBBBBBBBB",  1532012400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511922222222", "APN TESTE", "Stop"           , 1000L, 1000L, "BBBBBBBBBBBBBBBB",  1532037600L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Start"          , 0L, 0L, "CCCCCCCCCCCCCCCC",  1531908000L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 250L, 125L, "CCCCCCCCCCCCCCCC",  1531951200L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 500L, 250L, "CCCCCCCCCCCCCCCC",  1531994400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511933333333", "APN TESTE", "Stop"           , 1000L, 500L, "CCCCCCCCCCCCCCCC",  1532012400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Start"          , 0L, 0L, "DDDDDDDDDDDDDDDD",  1532012400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 250L, 125L, "DDDDDDDDDDDDDDDD",  1532037600L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 500L, 250L, "DDDDDDDDDDDDDDDD",  1532080800L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511933333333", "APN TESTE", "Stop"           , 1000L, 500L, "DDDDDDDDDDDDDDDD",  1532098800L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Start"          , 0L, 0L, "EEEEEEEEEEEEEEEE", 1531972800L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511944444444", "APN TESTE", "Interim-Update" , 500L, 250L, "EEEEEEEEEEEEEEEE",  1531994400L, 0, 0,1000L),
        Row("","0x0027f4501073c646","5511944444444", "APN TESTE", "Stop"           , 1000L, 1000L, "EEEEEEEEEEEEEEEE",  1532030400L, 0, 0,1000L),
        Row("3573060307551601","0x0027f4501073c646","5511966666666", "APN TESTE", "Start"          , 0L, 0L,       "FFFFFFFFFFFFFFFF", 1531994400L, 0, 0, 1000L),
        Row("3573060307551601","0x0027f4501073c646","5511966666666", "APN TESTE", "Interim-Update" , 50L, 50L,   "FFFFFFFFFFFFFFFF", 1531994400L, 0, 0, 1000L)
      ),
    "teste9" ->
      Seq(
        Row("3573060307551601","0x0027f4501073c646","5511933333333", "APN TESTE", "Interim-Update" , 120L, 120L,   "ZZZZZZZZZZZZZZZZ",  1531908000L, 0, 0,1000L), //18-07-2018 10:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Start"          , 0L, 0L,       "AAAAAAAAAAAAAAAA",  1531908000L, 0, 0,1000L), //18-07-2018 10:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 200L, 100L,   "AAAAAAAAAAAAAAAA",  1531951200L, 0, 0,1000L), //18-07-2018 22:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 400L, 200L,   "AAAAAAAAAAAAAAAA",  1531994400L, 0, 0,1000L), //19-07-2018 10:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 600L, 300L,   "AAAAAAAAAAAAAAAA",  1532012400L, 0, 0,1000L), //19-07-2018 15:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 800L, 400L,   "AAAAAAAAAAAAAAAA",  1532037600L, 0, 0,1000L), //19-07-2018 22:00
        Row("3573060307551601","0x0027f4501073c646","5511911111111", "APN TESTE", "Interim-Update" , 1000L, 500L,  "AAAAAAAAAAAAAAAA",  1532080800L, 0, 0,1000L), //20-07-2018 10:00
        Row("","0x0027f4501073c646","5511911111111", "APN TESTE", "Stop"           , 1200L, 600L,  "AAAAAAAAAAAAAAAA",  1532098800L, 0, 0,1000L), //20-07-2018 15:00
        Row("3573060307551601","0x0027f4501073c646","5511922222222", "APN TESTE", "Interim-Update" , 1234L, 567L,  "BBBBBBBBBBBBBBBB",  1532012400L, 0, 0,1000L) //19-07-2018 15:00
      )
  )

  val cadastroCliente_Data =
    Map(
      "teste1" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511922222222", "20180719"),
          Row("0000000002", "5511933333333", "20180719")
        ),
      "teste2" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511922222222", "20180719"),
          Row("0000000002", "5511933333333", "20180719")
        ),
      "teste3" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511922222222", "20180719"),
          Row("0000000002", "5511933333333", "20180719")
        ),
      "teste4" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511922222222", "20180719"),
          Row("0000000002", "5511933333333", "20180719")
        ),
      "teste5" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511944444444", "20180719"),
          Row("0000000002", "5511933333333", "20180719")
        ),
      "teste6" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719")
        ),
      "teste7" ->
        Seq(
          Row("0000000001", "5511944444444", "20180719"),
          Row("0000000005", "5511966666666", "20180719")
        ),
      "teste8" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511922222222", "20180719"),
          Row("0000000002", "5511933333333", "20180719"),
          Row("0000000001", "5511944444444", "20180719"),
          Row("0000000005", "5511966666666", "20180719")
        ),
      "teste9" ->
        Seq(
          Row("0000000001", "5511911111111", "20180719"),
          Row("0000000001", "5511922222222", "20180719"),
          Row("0000000002", "5511933333333", "20180719")
        )
    )
}
