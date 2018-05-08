import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]){
    // val config = new SparkConf
    // val sc = new SparkContext("local", "Test", config)
    val spark = SparkSession.builder.appName("test")
    .config("spark.master", "local")
    .getOrCreate()

    import spark.implicits._
    val file = spark.read.textFile("example.json")
    val lines = file.map(line => line)
    lines.show()

  }
}

