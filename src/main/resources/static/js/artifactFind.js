$(document).ready(function (){
    optionMake();


    $('#searchBtn').click(function (){

        const params = {
            "charName" : $('#char_name').val()
            ,"partyType" : $('#party_type').val()
            ,"userName" : $('#user_name').val()
            ,"artifactCd" : $('#artifact_name').val()
        }

        $.ajax({
            type:'get'
            ,url:'/v1/artifact/list'
            ,data: params
            ,contentType:'application/json'
            ,dataType:'json'
            ,success:function(data){
                const row = data
                const tbody = $('#artifact_list');
                const flower = row.flowers;
                const feather = row.feathers;
                const hourglass = row.hourglasses;
                const holyGrail = row.holyGrails;
                const crown = row.crowns;

                tableMade(flower, tbody);
                tableMade(feather, tbody);
                tableMade(hourglass, tbody);
                tableMade(holyGrail, tbody);
                tableMade(crown, tbody);

                tbody.hide();
                $('.꽃').show();
            }
            ,error:function(xhr, error, msg){
                console.log(xhr);
                console.log(error);
                console.log(msg);
                if(error === 'error'){
                    alert('없는 유저입니다.')
                }
            }
        })
    });// searchBtn click

    function tableMade(row ,tbody){

        tbody.empty();
        for(let i = 0; i < row.length; i++){
            const tr = $("<tr class ="+ row.artifactPart + "></tr>");

            const td1 = $("<td class = 'artifactCd'>" + row.artifactCd + "</td>");
            const td2 = $("<td class = 'artifactPart'>" + row.artifactPart + "</td>");
            const td3 = $("<td class = 'attack'>" + row.attack + "</td>");
            const td4 = $("<td class = 'attack_per'>" + row.attackPer + "</td>");
            const td5 = $("<td class = 'defense'>" + row.defense + "</td>");
            const td6 = $("<td class = 'defense_per'>" + row.defensePer + "</td>");
            const td8 = $("<td class = 'health_point'>" + row.healthPoint + "</td>");
            const td9 = $("<td class = 'health_point_per'>" + row.healthPointPer + "</td>");
            const td10 = $("<td class = 'element_mastery'>" + row.elementMastery + "</td>");
            const td11 = $("<td class = 'element_charge'>" + row.elementCharge + "</td>");
            const td12 = $("<td class = 'critical_probability'>" + row.criticalProbability + "</td>");
            const td13 = $("<td class = 'critical_damage'>" + row.criticalDamage + "</td>");
            const td14 = $("<td class = 'artifact_score'>" + row.artifactScore + "</td>");
            tbody.append(tr.append(td1, td2, td3, td4, td5, td6, td7, td8, td9, td10, td11, td12, td13, td14));

        }

    } //테이블 생성

    $('#flower').click()








})