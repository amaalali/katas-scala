package kata.rotatedWords

object RotatedWords {
  def apply(input: Seq[String]): Set[Set[String]] = {
    val sameLength = (a: String, b: String) => a.length == b.length
    val isCycle = (source: String, test: String) => (source+source).toLowerCase.contains(test.toLowerCase)
    
    @scala.annotation.tailrec
    def partitionByCycles(toPartition: Seq[String], partitioned: Set[Set[String]]): Set[Set[String]] = {
      if (toPartition.isEmpty)
        partitioned
      else {
        val testItem = toPartition.head
        val (newPartition, unPartitioned) = toPartition.toSet.partition(itemToTest =>
          sameLength(testItem, itemToTest) && isCycle(testItem, itemToTest)
        )

        val combinedPartitions = partitioned + newPartition

        partitionByCycles(unPartitioned.toList, combinedPartitions)
      }
    }

    partitionByCycles(input, Set.empty)
  }
}
