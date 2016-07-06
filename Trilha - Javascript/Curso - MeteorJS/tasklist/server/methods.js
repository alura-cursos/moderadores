Meteor.methods({
    "adiciona" : function(tarefa) {
        Tarefas.insert({nome : tarefa, date : new Date(), usuario : this.userId});
    },
    "remove" : function(id) {
        Tarefas.remove({_id : id, usuario : this.userId});
    }
})