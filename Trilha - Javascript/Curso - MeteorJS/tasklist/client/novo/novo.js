Template.novo.events({
    "submit form" : function (e, template) {
        e.preventDefault();
        var $input = $('#tarefa');
        var tarefa = $input.val();
        Meteor.call("adiciona", tarefa);
        $input.val('');
        $input.focus();
    }
});