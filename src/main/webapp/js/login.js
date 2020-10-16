
$.validator.setDefaults({
	submitHandler: function() {
		form.submit();
	}
});
$(document).ready(function() {
	$('#form2').validate({
		rules: {
			userName: "required",
			
			passWord: {
				required: true,
			},
			confirmlogo: "required",
		},
		messages: {
			userName: "用户名输入不能为空",
			
			passWord: {
				required: "密码输入不能为空",
			},
			confirmlogo: "验证码输入不能为空",
		}
	});
});