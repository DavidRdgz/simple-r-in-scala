# simple-r-in-scala
quick simple intro to using r in scala. basically, getting and setting objects need to be in an Array[T] with T = {Int, Double, String}.

# Usage
Quick introduction to working with R in Scala. There are a variety of reasons for doing this but perhaps the biggest reason is quickly prototyping an idea stands out.

There are trade-offs, though. For example, your data may best be described as a data-frame with a variety of types such as Int, Doubles, and Strings. From my experience you will need to pass in these types as String and re-convert things once the data frame is in R. Examples 5 & 6 show how to deal with this.

# RinScala1

Shows how to pull data from an R object to a Scala object.

# RinScala2

Shows how to write R scripts locallly and then pull a vector of results out into a Breeze object. A Breeze DenseVector object is like a numpy vector.

# RinScala3

Shows how a variety of typical R patterns can be written and suggests that you check your R code output against the Scala locally.

# RinScala4

Shows how you can load packages and return a Breeze DenseMatrix from a two dimensional array from R (i.e. Array[Array[T]]) where T can be Int, Double, String.

# RinScala5

Shows how to take data from Scala into R, by being really careful and aware of the data types, then run a model and return the confusion matrix.

# RinScala6

Shows how to load data from Scala into R by not being careful, but then recasting data into correct types in R. Then running a model and returning a confusion matrix.
