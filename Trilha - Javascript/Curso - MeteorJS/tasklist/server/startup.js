Meteor.startup(function() {
    Meteor.publish("tarefas", function() {
        return Tarefas.find({usuario : this.userId});
    });
});