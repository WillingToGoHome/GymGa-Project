<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 계정만들기 클릭 시 나타나는 모달 창 -->
    $(document).ready(function() {


    $(".registButton").click(function() {
        $(this).siblings(".modalContainer").show();
    });

    $(".cancelButton").click(function() {
    $(this).closest(".modalContainer").hide();
});
});
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    document.addEventListener("DOMContentLoaded", function (){
    var nextButton = document.getElementById("btn_submit");

    nextButton.addEventListener("click", function () {
    var modalContainer = document.querySelector(".modalContainer");
    modalContainer.style.display = "none";

    var modalContainer2 = document.querySelector(".modalContainer2");
    modalContainer2.style.display = "block";
});

    var prevButton = document.getElementById("btn_submit2");

    prevButton.addEventListener("click", function () {
    var modalContainer2 = document.querySelector(".modalContainer2");
    modalContainer2.style.display = "none";

    var modalContainer = document.querySelector(".modalContainer");
    modalContainer.style.display = "block";
});
});

<!-- 이용약관 클릭 스크립트 -->
    function fregister_submit(f)
    {
        if (!f.chk.checked) {
        alert("회원가입약관의 내용에 동의하셔야 회원가입 하실 수 있습니다.");
        f.chk.focus();
        return false;
    }
        if (!f.chk2.checked) {
        alert("개인정보처리방침안내의 내용에 동의하셔야 회원가입 하실 수 있습니다.");
        f.chk2.focus();
        return false;
    }
        return true;
    }

    jQuery(function ($){
    // 모두선택
    $("input[name=chk_all]").click(function (){
        if ($(this).prop('checked')) {
            $("input[name^=chk]").prop('checked', true);
        } else {
            $("input[name^=chk]").prop("checked", false);
        }
    });
});
