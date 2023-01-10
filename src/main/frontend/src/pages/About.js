import React, { useState } from "react";
import SaveData from "../data/SaveData";
import Select from "react-dropdown-select";
import axios from "axios";

const About = () => {

    const [request, setRequest] = useState({
        userName: ""
        ,artifactCd : 0
        ,artifactPart : ""
        ,mainOption : ""
        ,attack : 0
        ,attackPer : 0
        ,defense : 0
        ,defensePer : 0
        ,healthPoint : 0
        ,healthPointPer : 0
        ,elementMastery : 0
        ,elementCharge : 0
        ,criticalProbablity : 0
        ,criticalDamage : 0 
    })

    const [artifactCd , setArtifactCd] = useState(null)
    const [artipactPart ,setArtifactPart] = useState("")

    const onChangeInput = (e) => {
        setRequest({
            ...request,
            [e.target.id]: e.target.value,
        });
    };

    const SendArtifact = () => {
        setRequest({
            ...request
            ,artifactCd : artifactCd.value
           ,artipactPart : artipactPart.valueOf
        })

        console.log(request)

        axios.post('v1/artifact/register', request);
    }

    return (
    <div>
        <h1> 성유물 등록 화면</h1>
        <div className="form-group">
            <label htmlFor="user">유저 이름</label>
            <input type="text" id="userName" name="userName" placeholder="유저 이름을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="artifact_name">성유물 이름 </label>
            <Select id = "artifactCd" name="artifactCd" options = {SaveData.ArtifactCd} onChange={setArtifactCd}></Select>
            <label htmlFor="artifact_part">성유물 부위 </label>
            <Select id = "artifact_part" name="artifactPart" options = {SaveData.ArtifactPart} onChange={setArtifactPart}></Select>
            <label htmlFor="main_option">메인 옵션</label>
            <input type="text" id="main_option" name="mainOption" placeholder="메인 옵션을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="attack">공격력</label>
            <input type="number" id="attack" name="attack" placeholder="공격력을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="attack_percent">공격력 퍼센트</label>
            <input type="number" id="attack_percent" name="attackPer" placeholder="공격력 퍼센트를 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="defense">방어력</label>
            <input type="number" id="defense" name="defense" placeholder="방어력을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="defense_percent">방어력 퍼센트</label>
            <input type="number" id="defense_percent" name="defensePer" placeholder="방어력 퍼센트를 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="health_point">체력</label>
            <input type="number" id="health_point" name="healthPoint" placeholder="체력을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="health_point_percent">체력 퍼센트</label>
            <input type="number" id="health_point_percent" name="healthPointPer" placeholder="체력 퍼센트를 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="element_mastery">원소 마스터리</label>
            <input type="number" id="element_mastery" name="elementMastery" placeholder="원소 마스터리를 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="element_charge">원소 충전 효율</label>
            <input type="number" id="element_charge" name="elementCharge" placeholder="원소 충전 효율을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="critical_probability">치명타 확률</label>
            <input type="number" id="critical_probability" name="criticalProbablity" placeholder="치명타 확률을 입력하세요" onChange={onChangeInput}/>
            <label htmlFor="critical_damage"> 치명타 데미지</label>
            <input type="number" id="critical_damage" name="criticalDamage" placeholder="치명타 피해를 입력하세요" onChange={onChangeInput}/>
        </div>
    <button id="saveButton" type="submit" onClick={SendArtifact}>등록</button>
    </div>
    );
};

export default About;