function writeform() {
		var thisform = document.writefrm;	// 폼 저장
		thisform.method = "post";
		thisform.action = "/board2/insert";
		var id_subject = document.getElementById('id_subject').value;	// 텍스트상자의 값
		if (id_subject == '') {
			alert('제목을 입력해야 합니다.');
		}  else {
			thisform.submit();	// 폼 전송
		}
	};
	function writeform2() {
		var thisform = document.writefrm;	// 폼 저장
		thisform.method = "post";
		thisform.action = "/board2/insert";
		var id_subject = document.getElementById('id_subject').value;	// 텍스트상자의 값
		if (id_subject == '') {
			alert('제목을 입력해야 합니다2.');
		}  else {
			thisform.submit();	// 폼 전송
		}
	};