object Main extends {
  def main(args: Array[String]): Unit = {
    println("Files Listing Command Line");
    if(args.length == 0) {
      println("Not enough args")
    } else {
      var path = ""
      args.sliding(2, 2).toList.collect {
        case Array("--path", pathName: String) => path = pathName
      }
      val listOfFiles = new Files(path)
      println("================================================")
      println("Number of files in directory and sub directories: " + listOfFiles.list.length)
      println("================================================")
    }
  }
}