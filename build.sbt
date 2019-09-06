name := "PrimeroProjeto"
version := "0.1"
scalaVersion := "2.12.0"

resolvers += "Cloudera Repository" at "https://repository.cloudera.com/content/repositories/releases/"
resolvers += "Cloudera Artifcatory" at "https://repository.cloudera.com/artifactory/public/"

libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.4.3" % "provided"
  , "org.apache.spark" %% "spark-sql" % "2.4.3" % "provided"
  , "org.apache.spark" %% "spark-hive" % "2.4.3" % "provided"
  , "com.typesafe" % "config" % "1.2.0"
  , "org.scalatest" %% "scalatest" % "3.0.0" % "test"
  , "com.holdenkarau" %% "spark-testing-base" % "2.4.2_0.12.0" % "test"
  , "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % "test"
)

assemblyMergeStrategy in assembly := {
  case PathList("scala", "test", "resources", "application.conf") =>
    MergeStrategy.discard
  case x =>
    val defaultStrategy = (assemblyMergeStrategy in assembly).value
    defaultStrategy(x)
}

