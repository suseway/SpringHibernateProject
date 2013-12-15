$.validator.setDefaults({
	highlight: function(input) {
		$(input).addClass("ui-state-highlight");
	},
	unhighlight: function(input) {
		$(input).removeClass("ui-state-highlight");
	}
});

$().ready(function() {

	$("#formulario").validate({
		rules: {
			code: {
				required: true,
				number: true,
				minlength: 2,
				maxlength: 8,
			},
			name: {
				required: true,
				letras: true,
				
			},
			empresa:  {
				required: true,
				letras: true,
			},
			user:  {
				required: true,
				
			},
			tel:{
				required: true,
				number: true,
				
			},
			fecha: "required",
			cantidad: "required",
			login: "required",
			password: "required",
			preunit: "required",
			precant: "required",
			
			lastname: "required",
			
			username: {
				required: true,
				minlength: 2
			},
			
			nuevologin: {
				required: true,
				minlength: 5
			},
			antiguapassword: {
				required: true,
				minlength: 5
			},
			password: {
				required: true,
				minlength: 5
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			},
			correo: {
				required: true,
				email: true
			},
			agree: "required"
		},
		messages: {
			calle: "introducir calle",
			fecha: "introducir fecha",
			login: "introducir login",
			password: "Type password",
			user: "Enter user",
			
			lastname: "Please enter your lastname",
			username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Type the password...",
				minlength: "Min 5 digits"
			},
			confirm_password: {
				required: "Insertar Clave",
				minlength: "Minimo 5 digitos",
				equalTo: "Por favor repetir la clave"
			},
			email: "Please enter a valid email address",
			correo: "introducir un correo valido",
			agree: "Please accept our policy"
		}
	});
	
	// propose username by combining first- and lastname
	$("#username").focus(function() {
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		if(firstname && lastname && !this.value) {
			this.value = firstname + "." + lastname;
		}
	});
	
	//code to hide topic selection, disable for demo
	var newsletter = $("#newsletter");
	// newsletter topics are optional, hide at first
	var inital = newsletter.is(":checked");
	var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
	var topicInputs = topics.find("input").attr("disabled", !inital);
	// show when newsletter is checked
	newsletter.click(function() {
		topics[this.checked ? "removeClass" : "addClass"]("gray");
		topicInputs.attr("disabled", !this.checked);
	});
	
	$("#signupForm input:not(:submit)").addClass("ui-widget-content");
	
	$(":submit").button();
});