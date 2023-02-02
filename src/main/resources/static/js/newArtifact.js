$(document).ready(function(){
    optionMake();

    $('#saveButton').click(function (){
        const userName = $('#user_name').val();
        const artifactCd = $('#artifact_name').val();
        const artifactPart = $('#artifact_part').val();
        const mainOption = $('#main_option').val();
        const attack = $('#attack').val();
        const attackPer = $('#attack_percent').val();
        const defense = $('#defense').val();
        const defensePer = $('#defense_percent').val();
        const healthPoint = $('#health_point').val();
        const healthPointPer = $('#health_point_percent').val();
        const elementMastery = $('#element_mastery').val();
        const elementCharge = $('#element_charge').val();
        const criticalProbability = $('#critical_probability').val();
        const criticalDamage = $('#critical_damage').val();

        const params =JSON.stringify({
            "userName" : userName
            ,"artifactCd" : artifactCd
            ,"artifactPart" : artifactPart
            ,"mainOption" : mainOption
            ,"attack" : attack
            ,"attackPer": attackPer
            ,"defense" : defense
            ,"defensePer" : defensePer
            ,"healthPoint" : healthPoint
            ,"healthPointPer" : healthPointPer
            ,"elementMastery" : elementMastery
            ,"elementCharge" : elementCharge
            ,"criticalProbability" : criticalProbability
            ,"criticalDamage" : criticalDamage
        });

        $.ajax({
            type:'post'
            ,url:'/v1/artifact/register'
            ,data: params
            ,contentType:'application/json'
            ,dataType:'json'
            ,success:function(data){
                alert('등록되었습니다.');
                document.location.reload();
            }
            ,error:function(xhr, error, msg){
                console.log(xhr);
                console.log(error);
                console.log(msg);

                if(error === 'error'){
                    alert('없는 유저입니다.')
                }
            }
        });
    });

    $('#calculationButton').click(function (){
        const aYn = $('#a_yn').prop("checked");
        const apYn = $('#ap_yn').prop("checked");
        const dYn = $('#d_yn').prop("checked");
        const dpYn = $('#dp_yn').prop("checked");
        const hYn = $('#h_yn').prop("checked");
        const hpYn = $('#hp_yn').prop("checked");
        const emYn = $('#em_yn').prop("checked");
        const ecYn = $('#ec_yn').prop("checked");
        const cpYn = $('#cp_yn').prop("checked");
        const cdYn = $('#cd_yn').prop("checked");

        const aT = aYn ? $('#attack').val() : 0;
        const apT = apYn ? $('#attack_percent').val() : 0;
        const dT = dYn ? $('#defense').val(): 0;
        const dpT = dpYn ? $('#defense_percent').val(): 0;
        const hT = hYn ? $('#health_point').val(): 0;
        const hpT = hpYn ? $('#health_point_percent').val(): 0;
        const emT = emYn ? $('#element_mastery').val(): 0;
        const ecT = ecYn ? $('#element_charge').val(): 0;
        const cpT = cpYn ? $('#critical_probability').val(): 0;
        const cdT = cdYn ? $('#critical_damage').val(): 0;

        score(aT, apT, dT, dpT, hT, hpT, emT, ecT, cpT, cdT);

    });

    function score(aT, apT, dT, dpT, hT, hpT, emT, ecT, cpT, cdT){

        const part = $('#artifact_part').val();
        const scoreDiv = $('#score');
        scoreDiv.removeClass();

        const score = ((aT/46.4) + (apT/5.8) + (dT/51.1) +(dpT/7.3)
            + (hpT/5.8) + (hT/696) + (emT/23)
            + (ecT/6.5) + (cpT/3.9) + (cdT/7.8)).toFixed(2);

        if(part === "꽃" || part === "깃털"){
            if(score < 5.88){
                scoreDiv.addClass('red');
            }else if(score >= 6.39){
                scoreDiv.addClass('blue');
            }else {
                scoreDiv.addClass('green');
            }
        }else if(part === "시계" || part === "성배" || part === "왕관"){
            if(score < 4.48){
                scoreDiv.addClass('red');
            }else if(score >= 4.99){
                scoreDiv.addClass('blue');
            }else {
                scoreDiv.addClass('green');
            }
        }

        scoreDiv.html(score);
    }


})