function optionMake(){
    const artifactCd = data().artifactCd;
    const artifactPart = data().artifactPart;
    const hourGlass = data().hourGlass;
    const holyGrail =  data().holyGrail;
    const crown = data().crown;
    const element = data().element;
    const fire = data().fire;
    const water = data().water;
    const wind = data().wind;
    const rock = data().rock;
    const ice = data().ice;
    const lightning = data().lightning;
    const grass = data().grass;
    const party = data().party;

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
        }
    }

    function elementMake(){
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