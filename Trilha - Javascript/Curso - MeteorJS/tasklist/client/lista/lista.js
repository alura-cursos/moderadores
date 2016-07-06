Template.lista.helpers({
    tarefas : function() {
        return Tarefas.find();
    },
    formatarData : function() {
        return moment(this.data).format('DD/MM/YYYY HH:mm');
    }
});

Template.lista.events({
    "click button" : function(e, template) {
        e.preventDefault();
        Meteor.call("remove", this._id);
    }
});