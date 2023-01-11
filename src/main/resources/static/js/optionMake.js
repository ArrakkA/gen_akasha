function optionMake(){

    const artifactCd = ["검투", "악단", "왕실", "기사도", "소녀", "청록", "반암", "유성", "뇌명", "번분", "현인", "마녀",
        "얼음", "몰락", "천암", "창백", "시메", "절연", "껍데기", "조개", "진사", "제사", "숲기", "도금", "누각", "낙원"];

    const artifactPart = ["꽃", "깃털", "시계", "성배", "왕관"];

    const hourGlass = ["공퍼", "체퍼", "방퍼", "원충", "원마"];

    const holyGrail =  ["공퍼", "체퍼", "방퍼" , "불원피", "얼음원피", "물원피", "바위원피", "바람원피", "풀원피", "물리피해", "번개원피", "원마"];

    const crown = ["공퍼", "체퍼", "방퍼", "원마", "치확", "치피", "치유"];


    const artifactName = $('#artifact_name');
    const artifactPartName = $('#artifact_part');
    const artifactPartPart = $('#main_option');


    artifactPartName.change(function (){
        partPartMake();
    })

    function nameMake(){

        artifactName.empty();
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

    nameMake();
    partMake();
    partPartMake();

}