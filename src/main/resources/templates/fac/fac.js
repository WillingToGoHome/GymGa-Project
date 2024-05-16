function sendRequest() {
    // 선택된 회원 코드 가져오기
    const selectedFacCode = document.getElementById("facCode").value;
    // userCode 파라미터를 포함하여 URL로 이동
    window.location.href = "/fac/select/personal?facCode=" + selectedFacCode;
}


function submitForm() {

// 폼 데이터 가져오기
    const formData = new FormData(document.getElementById("registForm"))


// POST 요청 보내기
    fetch("/fac/regist", {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (response.ok) {
// 성공적으로 처리된 경우 모달 닫기
                $('#facActionModal').modal('hide');
                window.location.href = "/fac/select";


            } else {
// 실패한 경우 오류 메시지 표시
                console.error('등록 실패');
            }
        })
        .catch(error => console.error('에러 발생:', error));
}




function submitForm2() {

// 폼 데이터 가져오기
    const formData = new FormData(document.getElementById("updateForm"));

// POST 요청 보내기
    fetch("/fac/update", {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (response.ok) {
// 성공적으로 처리된 경우 모달 닫기
                $('#updateModal').modal('hide');
                $('#facActionModal').modal('hide');
                window.location.href = "/fac/select";

            } else {
// 실패한 경우 오류 메시지 표시
                console.error('등록 실패');
            }
        })
        .catch(error => console.error('에러 발생:', error));
}



function submitForm3() {

// 폼 데이터 가져오기
    const formData = new FormData(document.getElementById("deleteForm"));

// POST 요청 보내기
    fetch("/fac/delete", {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (response.ok) {
// 성공적으로 처리된 경우 모달 닫기
                $('#facActionModal').modal('hide');
                window.location.href = "/fac/select";

            } else {
// 실패한 경우 오류 메시지 표시
                console.error('등록 실패');
            }
        })
        .catch(error => console.error('에러 발생:', error));
}



