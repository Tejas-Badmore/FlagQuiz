package com.androidsolution.flagquiz

object Constants{
    private const val basicQuestion:String = "What country does this flag belongs to?"
    fun getQuestions(): ArrayList<Questions>{
        val questionList = ArrayList<Questions>()

        val ques1= Questions(1, basicQuestion,R.drawable.ic_flag_of_argentina,
            "Argentina","Mexico","Gaboan","Germany",
            1)
        questionList.add(ques1)

        val ques2= Questions(2, basicQuestion,R.drawable.ic_flag_of_australia,
            "France","Australia","Belgium","Germany",2)
        questionList.add(ques2)


        val ques3= Questions(3, basicQuestion,R.drawable.ic_flag_of_belgium,
            "Denmark","Finland","Belgium","Kuwiat",3)
        questionList.add(ques3)

        val ques4= Questions(4, basicQuestion,R.drawable.ic_flag_of_brazil,
            "Kuwait","Belize","Belgium","Brazil",4)
        questionList.add(ques4)

        val ques5= Questions(5, basicQuestion,R.drawable.ic_flag_of_denmark,
            "Fiji","Argentina","New Zealand","Denmark",4)
        questionList.add(ques5)

        val ques6= Questions(6, basicQuestion,R.drawable.ic_flag_of_fiji,
            "Mexico","Fiji","Belgium","Kuwait",2)
        questionList.add(ques6)

        val ques7= Questions(7, basicQuestion,R.drawable.ic_flag_of_germany,
            "Mexico","Belgium","Fiji","Germany",4)
        questionList.add(ques7)

        val ques8= Questions(8, basicQuestion,R.drawable.ic_flag_of_india,
            "Canada","India","South Korea","Australia",2)
        questionList.add(ques8)

        val ques9= Questions(9, basicQuestion,R.drawable.ic_flag_of_kuwait,
            "Kuwait","Denmark","Fiji","USA",1)
        questionList.add(ques9)

        val ques10= Questions(10, basicQuestion,R.drawable.ic_flag_of_new_zealand,
            "New Zealand","Australia","Denmark","Germany",1)
        questionList.add(ques10)

        return questionList
    }
}