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
    })


})