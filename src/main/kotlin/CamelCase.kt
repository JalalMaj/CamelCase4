
import java.util.Scanner

fun main(args: Array<String>) {
    // define an input scan
    val scan = Scanner(System.`in`)
    // while input has sting
    while (scan.hasNext()) {
        var input = scan.nextLine().trim()
        if (input[0] == 'C') {
            println(combine(input))
        } else if (input[0] == 'S') {
            println(split(input))
        }
        else{
            // break the input
            break
        }
    }


}

fun split(input:String):String{
    var output :String = ""
    for(i in 4 until input.length){
     if(input[i].isLowerCase()){
         output= output + "${input[i]}"
     }
        if(input[i].isUpperCase()){
            output = output +" "+"${input[i].lowercase()}"
        }
       output =  output.removePrefix(" ")
    }
    return(output)
}

fun combine(input:String):String {
    var output: String =input.substring(4)
    var j=0
    var result = ""
    var arr = mutableListOf<String>("")
    var chars = mutableListOf<Char>()
    // To capatilize the first lettter in each word in the string
    output = output.trim().split("\\s+".toRegex())
        .map { it.capitalize() }.joinToString(" ")

    /* To replace the space by @
        output = output.replace("\\s".toRegex(),"@")

     */
    // for changing each word to array of Chars and then store them in array list of string
        output.forEach {

            if(it != ' '){
                chars.add(it)
            }

            else if(it == ' ') {
              // chars[0] = chars[0].toUpperCase()
                chars.forEach {
                    arr[j] = arr[j] + it.toString()
                }
                j++
                arr.add(j, "")
                chars.removeAll(chars)
            }
            }
    // The last word is add seperately as the above function will not store last word
        var last =  output.substringAfterLast(' ')
        //var char = last.get(0).uppercase()
        //last = last.substring(1)
        //last = char+last
        arr.removeAt(arr.lastIndex)
        arr.add(last)
    // Cases of Input
    if( input[2] == 'M'){
        arr[0] = arr[0].toLowerCase()

        arr.forEach{
            result= result + it+""
        }
        result +="()"
    }
    if( input[2] == 'C'){
        arr.forEach{
            result= result + it+""
        }
    }
    if( input[2] == 'V'){
        arr[0] = arr[0].toLowerCase()
        arr.forEach{
            result= result + it+""
        }
    }
    //Return Result
    return result
}