package facespace

import grails.rest.RestfulController

class TransactionController extends RestfulController{
    static allowedMethods = [addTransaction: 'POST']
    static responseFormats = ['json', 'xml']

    TransactionController(){
        super(Transaction)
    }
    //for fetch also
    def addTransaction(){
        def uAmount = params.amount
        def uCategory = params.category
        def uDate = params.date
        new Transaction(amount: uAmount, category: uCategory, date: uDate).save()
        System.out.print("Transaction added")
        def trans = Transaction.get(1)
        if(trans == null){
            response.status = 404
        }
        else{
            response.status = 200
        }

        //check that username exists and if it's not null then add a new transaction
        //def account = UserAccount.find{userName == uname}
        //if (account != null){
        //respond account.getProfile().get_transactions()
        //create new transaction object and save it
        //new Transaction(amount: amount, category: category, date: date).save()
        //check that transaction is in list?
        //}
        //else {
        //response.status = 404
        //}

        // check transaction can be found in database
        //def check_transaction = Profile.getTransactions()

        //check if transaction was added (works for single transaction added)
//        if(!(temp + 1 == count)){
//            response.status = 404
//        }
//        else {
//            response.status = 200
//        }

    }

    //for fetch command
    def get_transactions(){
        return transactions
    }
}
