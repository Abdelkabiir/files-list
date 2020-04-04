import java.io.File
import scala.collection.mutable.ArrayBuffer

class Files(path: String) {
  /**
   * I need a recursive function to check for every xFile entry :
   * if it's a file then return it
   * else : lists every xFile and repeat the same check
   */
  protected val allFiles: Array[File] = (new File(path))
    .listFiles
  val list = ArrayBuffer[String]()
  private def add(fileName: String): ArrayBuffer[String] = list.addOne(fileName)
  private def get(file: File): Unit =
    if(file.isFile) add(file.getName)
    else if (file.isDirectory)
      file
        .listFiles()
        .foreach(get)
  allFiles.foreach(get)
}