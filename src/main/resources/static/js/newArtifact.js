$(document).ready(function(){
    $('#saveButton').click(function (){
        const user = $('#user').val();
        const artifactName = $('#artifact_name').val();
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

        console.log(artifactPart);

        const params ={
            "userName" : user
            ,"artifactName" : artifactName
            ,"artifactPart" : artifactPart
            ,"mainOption" : mainOption
            ,"attack" : attack
            ,"attackPer" : attackPer
            ,"defense" : defense
            ,"defensePer" : defensePer
            ,"healthPoint" : healthPoint
            ,"healthPointPer" : healthPointPer
            ,"elementMastery" : elementMastery
            ,"elementCharge" : elementCharge
            ,"criticalProbability" : criticalProbability
            ,"criticalDamage" : criticalDamage
        };

        console.log(params)


        $.ajax({
            type:'post'
            ,url:'/v1/artifact/register'
            ,data:params
            ,dataType:'json'
            ,success:function(result){
                console.log("성공");
            }
            ,error:function(){
                console.log("실패")
            }
        });//ajax


    })





})