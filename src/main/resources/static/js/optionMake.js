function optionMake(){

    const artifactCd = ["검투", "악단", "왕실", "기사도", "소녀", "청록", "반암", "유성", "뇌명", "번분", "현인", "마녀",
        "얼음", "몰락", "천암", "창백", "시메", "절연", "껍데기", "조개", "진사", "제사", "숲기", "도금", "누각", "낙원"];

    const artifactPart = ["꽃", "깃털", "시계", "성배", "왕관"];

    const hourGlass = ["공퍼", "체퍼", "방퍼", "원충", "원마"];

    const holyGrail =  ["공퍼", "체퍼", "방퍼" , "불원피", "얼음원피", "물원피", "바위원피", "바람원피", "풀원피", "물리피해", "번개원피", "원마"];

    const crown = ["공퍼", "체퍼", "방퍼", "원마", "치확", "치피", "치유"];

    const element =["불", "물", "바람", "바위", "얼음", "번개", "풀"];

    const fire = ["다이루크", "호두", "요이미야", "클레", "엠버", "향릉", "베넷", "신염", "연비", "토마"];

    const water = ["모나", "야란", "타르탈리아", "아야토", "코코미", "닐루", "행추", "바바라", "캔디스"];

    const wind = ["벤티", "카즈하", "진", "소", "방랑자", "설탈", "사유", "헤이조", "파루잔"];

    const rock = ["종려", "알베도", "이토", "응광", "고로", "노엘", "운근"];

    const ice = ["아야카", "감우", "유라", "신학", " 케이아", "로자리아", " 디오나", "중운", "레일라", "에일로이", "치치"];

    const lightning = ["라이덴", "각청", "미코", "사이노", "사라", "리사", "레이저", "북두", "피슬", "시노부", "도리"];

    const grass = ["나히다", "알하이탐", "타이나리", "콜레이", "요요"];

    const party = ["메인 딜러", "서브 딜러", "서포터", "범용", "빙결", "격변"];

    const artifactName = $('#artifact_name');
    const artifactPartName = $('#artifact_part');
    const artifactPartPart = $('#main_option');
    const elementType = $('#element_type');
    const charName = $('#char_name');
    const partyType = $('#party_type');

    artifactPartName.change(function (){
        partPartMake();
    })
    elementType.change(function (){
        charMake();
    })


    function nameMake(){

        for(let i = 0; i< artifactCd.length; i++){
            const op = $("<option>" + artifactCd[i] + "</option>");
            op.attr('value', i + 1);
            artifactName.append(op);
        }
    }

    function partMake() {

        artifactPartName.empty();
        for(let i=0; i< artifactPart.length; i++){
            const op = $("<option>" + artifactPart[i] + "</option>");
            op.attr('value', artifactPart[i]);
            artifactPartName.append(op);
        }
    }

    function partPartMake(){
        artifactPartPart.empty();
        switch (artifactPartName.val()){
            case "꽃":
                const op1 = $("<option> 깡체 </option>");
                op1.attr('value', '깡체');
                artifactPartPart.append(op1);
                break;

            case '깃털':
                const op2 = $("<option> 깡공 </option>");
                op2.attr('value', '깡공')
                artifactPartPart.append(op2);
                break;
            case '시계':

                for(let i=0; i <hourGlass.length; i++){
                    const op = $("<option>" + hourGlass[i] + "</option>");
                    op.attr('value', hourGlass[i])
                    artifactPartPart.append(op);
                }
                break;
            case '성배':
                for(let i=0; i <holyGrail.length; i++){
                    const op = $("<option>" + holyGrail[i] + "</option>");
                    op.attr('value', holyGrail[i])
                    artifactPartPart.append(op);
                }
                break;
            case '왕관':
                for(let i=0; i <crown.length; i++){
                    const op = $("<option>" + crown[i] + "</option>");
                    op.attr('value', crown[i])
                    artifactPartPart.append(op);
                }
                break;
            default:
                console.log("너 재대로 안체크했어");
        }
    }

    function elementMake(){
        elementType.empty();
        for(let i = 0; i< element.length; i++){
            const op = $("<option>" + element[i] + "</option>");
            op.attr('value', element[i]);
            elementType.append(op);
        }
    }

    function charMake(){
        charName.empty();
        switch (elementType.val()){
            case "불":
                for(let i=0; i <fire.length; i++){
                    const op = $("<option>" + fire[i] + "</option>");
                    op.attr('value', fire[i]);
                    charName.append(op);
                }
                break;
            case "물":
                for(let i=0; i <water.length; i++){
                    const op = $("<option>" + water[i] + "</option>");
                    op.attr('value', water[i]);
                    charName.append(op);
                }
                break;
            case '바람':
                for(let i=0; i <wind.length; i++){
                    const op = $("<option>" + wind[i] + "</option>");
                    op.attr('value', wind[i]);
                    charName.append(op);
                }
                break;
            case '바위':
                for(let i=0; i <rock.length; i++){
                    const op = $("<option>" + rock[i] + "</option>");
                    op.attr('value', rock[i]);
                    charName.append(op);
                }
                break;
            case '풀':
                for(let i=0; i <grass.length; i++){
                    const op = $("<option>" + grass[i] + "</option>");
                    op.attr('value', grass[i]);
                    charName.append(op);
                }
                break;
            case '얼음':
                for(let i=0; i <ice.length; i++){
                    const op = $("<option>" + ice[i] + "</option>");
                    op.attr('value', ice[i]);
                    charName.append(op);
                }
                break;
            case '번개':
                for(let i=0; i <lightning.length; i++){
                    const op = $("<option>" + lightning[i] + "</option>");
                    op.attr('value', lightning[i]);
                    charName.append(op);
                }
                break;
            default:
                console.log("속성 선택 실패");
        }
    }

    function partyTypeMake(){
        partyType.empty();
        for(let i = 0; i< party.length; i++){
            const op = $("<option>" + party[i] + "</option>");
            op.attr('value', party[i]);
            partyType.append(op);
        }
    }

    nameMake();
    partMake();
    partPartMake();
    elementMake();
    partyTypeMake();
}