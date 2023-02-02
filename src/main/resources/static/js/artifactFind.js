$(document).ready(function (){
    optionMake();
    const artifactCdName = data().artifactCd;

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

                tbody.empty();

                tableMade(flower, tbody);
                tableMade(feather, tbody);
                tableMade(hourglass, tbody);
                tableMade(holyGrail, tbody);
                tableMade(crown, tbody);


                $('.artifact_value').hide();
                $('.꽃').show();
            }
            ,error:function(xhr){
                alert(xhr.responseJSON.message);
            }
        })
    });// searchBtn click

    function tableMade(row ,tbody){
        for(let i = 0; i < row.length; i++){
            const tr = $("<tr class = " + row[i].artifactPart + "></tr>");
            tr.addClass("artifact_value");

            const td1 = $("<td class = 'artifactCd'>" + artifactCdName[row[i].artifactCd - 1] + "</td>");
            const td2 = $("<td class = 'artifactPart'>" + row[i].artifactPart + "</td>");
            const td3 = $("<td class = 'attack'>" + row[i].attack + "</td>");
            const td4 = $("<td class = 'attack_per'>" + row[i].attackPer + "</td>");
            const td5 = $("<td class = 'defense'>" + row[i].defense + "</td>");
            const td6 = $("<td class = 'defense_per'>" + row[i].defensePer + "</td>");
            const td7 = $("<td class = 'health_point'>" + row[i].healthPoint + "</td>");
            const td8 = $("<td class = 'health_point_per'>" + row[i].healthPointPer + "</td>");
            const td9 = $("<td class = 'element_mastery'>" + row[i].elementMastery + "</td>");
            const td10 = $("<td class = 'element_charge'>" + row[i].elementCharge + "</td>");
            const td11 = $("<td class = 'critical_probability'>" + row[i].criticalProbability + "</td>");
            const td12 = $("<td class = 'critical_damage'>" + row[i].criticalDamage + "</td>");
            const td13 = $("<td class = 'artifact_score'>" + row[i].artifactScore + "</td>");
            tbody.append(tr.append(td1, td2, td3, td4, td5, td6, td7, td8, td9, td10, td11, td12, td13));
        }

    } //테이블 생성


    $('#flower').click(function (){
        $('.artifact_value').hide();
        $('.꽃').show();
    })

    $('#feather').click(function (){
        $('.artifact_value').hide();
        $('.깃털').show();
    })

    $('#hourglass').click(function (){
        $('.artifact_value').hide();
        $('.시계').show();
    })

    $('#holyGrail').click(function (){
        $('.artifact_value').hide();
        $('.성배').show();
    })

    $('#crown').click(function (){
        $('.artifact_value').hide();
        $('.왕관').show();
    })

})