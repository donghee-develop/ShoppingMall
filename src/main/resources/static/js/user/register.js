const [registerBtn, cancelBtn] = document.getElementById('login-btn-section').querySelectorAll('button');

const emailTag = document.getElementById('email-input-div').querySelector('input');
const emailHead = document.getElementById('email-input-addr').querySelector('input');
const emailBody = document.getElementById('email-input-domain-manual').querySelector('input');
const emailChoose = document.getElementById('email-input-domain-auto').querySelector('select');

const phoneTag = document.getElementById('phone-input-div').querySelector('input');
const phoneHead = document.getElementById('phone-input-head').querySelector('select');
const phoneMiddle = document.getElementById('phone-input-middle').querySelector('input');
const phoneTail = document.getElementById('phone-input-tail').querySelector('input');

emailChoose.onchange = () => {
    if(emailChoose.value === '직접입력') {
        emailBody.readOnly = false;
    }else{
        emailBody.readOnly = true;
        emailBody.value = emailChoose.value;
    }
}

registerBtn.onclick = () => {
    emailTag.value = emailHead.value + '@' + emailBody.value;
    phoneTag.value = `${phoneHead.value}-${phoneMiddle.value}-${phoneTail.value}`;

    document.forms.item(0).submit();
}

cancelBtn.onclick = () =>{
    location.href = "/user/login";
}

IMP.init("imp24111301");
const certificationBtn = document.getElementById('certification-btn');
const impUid = document.getElementById('imp-uid');
// 본인 인증
certificationBtn.onclick = () => {
    IMP.certification(
        {
            // param
            pg: "inicis_unified.MIIiasTest", //본인인증 설정이 2개이상 되어 있는 경우 필수
        },
        function (rsp) {
            // callback
            console.log(rsp);
            if (rsp.success) {
                // 인증 성공 시 로직
                impUid.value = rsp["imp_uid"];
                certificationBtn.textContent = "본인 인증 완료";
                certificationBtn.disabled = true;
            } else {
                // 인증 실패 시 로직
                alert("본인 인증 완료 못함");
            }
        },
    );

}

