/*
* 
* deicer client class
*
*/
var Deicer = {
		serversalt : '',
		challenge : '',
		addUser:function() {
			$.post('/new_user.html', function(data) {
				  $('.result').html(data);
			});
		},
		init:function(challenge) {
			
			this.challenge = challenge;
			this.loadTinyMce();
			this.initTopMenuAndFormStyle();
			this.initDialogs();
			this.initBindings();
			
		},
		insertHashedPassword:function(form_id_string,withChallenge) {
			
			var unencrypted_password = $('#' + form_id_string + ' > #password').val();
			var salted_encrypted_password = hex_hmac_sha1(unencrypted_password,deicer.seversalt);
			var passwordhash = "";
		
			if (withChallenge==true) {
			
				passwordhash = hex_sha1(salted_encrypted_password+""+this.challenge);
						
			}else {
			
				passwordhash = salted_encrypted_password;
			
			}
			
			$('#' + form_id_string + ' > #password').val(passwordhash);
			
		},
		deletePost:function(postid) {
		
			$.post("/delete_post.html", { id: postid },
			   function(data){
			   alert(data);
			     /*$("html").replaceWith(data);*/
			   });
			
		},
		deletePage:function(pageid) {
		
				$.post("/delete_page.html", { id: pageid },
			   function(data){
			     /*$("html").replaceWith(data);*/
			   });
			   
		},
		loadTinyMce:function() {
		$('textarea.tinymce').tinymce({
		
			// Location of TinyMCE script
			script_url : '/static/tinymce/jscripts/tiny_mce/tiny_mce.js',

			// General options
			theme : "advanced",
			plugins : "pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,advlist",

			// Theme options
			theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
			theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
			theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
			theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",
			theme_advanced_toolbar_location : "top",
			theme_advanced_toolbar_align : "left",
			theme_advanced_statusbar_location : "bottom",
			theme_advanced_resizing : true,
			theme_advanced_resize_horizontal : false,
			
			// Example content CSS (should be your site CSS)
			//content_css : "css/content.css",

			// Drop lists for link/image/media/template dialogs
			template_external_list_url : "lists/template_list.js",
			external_link_list_url : "lists/link_list.js",
			external_image_list_url : "lists/image_list.js",
			media_external_list_url : "lists/media_list.js",

			// Replace values for the template plugin
			template_replace_values : {
				username : "Some User",
				staffid : "991234"
			}
			
		});
		},
		initTopMenuAndFormStyle:function() {
		    
		    $("ul.sf-menu").superfish({
           	 pathClass:  'current'
        	});

        	$("input").addClass("idle");
        	$("input").focus(function(){
           	 $(this).addClass("activeField").removeClass("idle");
	    	}).blur(function(){
	       	     $(this).removeClass("activeField").addClass("idle");
			});
			
		},
		initDialogs:function() {
		
					// Dialogs			
		$('#delete_page_dialog').dialog({
			autoOpen: false,
			width: 600,
			buttons: {
				"Yes": function() {
					var page_id = $(this).find("#page_id").html();
					Deicer.deletePage(page_id);
					$(this).dialog("close"); 
				}, 
				"No": function() { 
					$(this).dialog("close"); 
				} 
			}
		});
		
		$('#delete_post_dialog').dialog({
			autoOpen: false,
			width: 600,
			buttons: {
				"Yes": function() {
					var post_id = $(this).find("#post_id").html();
					Deicer.deletePost(post_id);
					$(this).dialog("close"); 
				}, 
				"No": function() { 
					$(this).dialog("close"); 
				} 
			}
		});
		
		$('#add_post_dialog').dialog({
			autoOpen: false,
			width: 720,
			buttons: {
				"Cancel": function() { 
					$(this).dialog("close"); 
				} 
			}
		});
		
		},
		initBindings:function() {
		
					// delete page
		$('.delete_page_link').click(function(){
		
			var idstring = $(this).attr("id");
			var page_id = idstring.substring(2,idstring.length);
			
			$("#delete_page_dialog > #page_id").html(page_id);
			$('#delete_page_dialog').dialog('open');
			return true; // set to false when javascript feature is up
			
		});
		
		// delete post
		$('.delete_post_link').click(function(){
		
			var idstring = $(this).attr("id");
			var post_id = idstring.substring(2,idstring.length);
			
			$("#delete_post_dialog > #post_id").html(post_id);
			$('#delete_post_dialog').dialog('open');
			return true; // set to false when javascript feature is up
			
		});
		
		// add post
		$('#add_post_link').click(function(){
		
			$('#add_post_dialog').dialog('open');
			return false;
			
		});	
		
		},
		initTransitions:function() {
			
			//$("#add_form").animate(...};
		
		}
		
};