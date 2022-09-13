import styled from "styled-components";
import StarRating from "./StarRating";

export default function GameContent() {
  return (
    <Content>
      <GameHeader>
        <img src="img/game.svg" alt="게임이미지" />
        <strong>Splendor</strong>
      </GameHeader>
      <GameBody>
        <GameCategory>
          <strong>게임상세</strong>
          <div>
            <dl>
              <dt>인원</dt>
              <dd>2-4명</dd>
            </dl>
            <dl>
              <dt>시간</dt>
              <dd>30분</dd>
            </dl>
            <dl>
              <dt>나이</dt>
              <dd>10세 이상</dd>
            </dl>
            <dl>
              <dt>카테고리</dt>
              <dd>가족게임</dd>
            </dl>
          </div>
        </GameCategory>
        <GameDetail>
          <strong>게임소개</strong>
          <span>
            보석을 구매하여 카드를 모아 승점 15점을 먼저 모으는 사람이 이긴다.
            펀딩판부터 시작해서 인기를 얻었다. 간단한 구성물과 직관적이면서
            이해하기 쉬운 룰로 보드게임 초보자도 쉽게 배울 수 있다. 그러나
            자신의 테크트리를 설계하는 동시에 상대방 빌드를 견제하는 등 고려할
            것이 많아 쉬운 룰이면서도 치밀하게 작전을 짜서 즐길 수 있는 게임.
          </span>
        </GameDetail>
      </GameBody>
      <ReviewContainer>
        <StarRating />
        <div>
          <InputContainer>
            <InputBox type="text" placeholder="작성자" />
            <InputBox type="password" placeholder="비밀번호" />
          </InputContainer>
          <TextBox
            name=""
            id=""
            cols="30"
            rows="10"
            placeholder="리뷰를 작성해주세요!"
          ></TextBox>
          <BtnBox>
            <InputBtn>작성</InputBtn>
          </BtnBox>
        </div>
        <div>
          <StarTime>
            <StarResult>
              <img src="img/star.svg" alt="" />
              <img src="img/star.svg" alt="" />
              <img src="img/star.svg" alt="" />
              <img src="img/star.svg" alt="" />
              <img src="img/star.svg" alt="" />
            </StarResult>
            <span>1분전</span>
          </StarTime>
          <CommentBox>
            <span>유현세</span>
            <p>너무 재미있네요 제 인생의 보드게임</p>
          </CommentBox>
        </div>
      </ReviewContainer>
    </Content>
  );
}

const Content = styled.div`
  margin: 2rem auto;
  overflow-y: auto;
  overflow-x: hidden;
  width: 100%;
  height: 41rem;
  strong {
    margin-top: 1rem;
    font-size: 1.3rem;
  }
`;
const GameHeader = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;
const GameBody = styled.div`
  margin-top: 2rem;
`;
const GameCategory = styled.div`
  div {
    margin-top: 0.5rem;
  }
  dl {
    display: flex;
    margin: 0.2rem 0 0.2rem 0;
  }
  dt {
    font-weight: 600;
  }
  dd {
    margin: 0 0 0 0.5rem;
    color: #9d9d9d;
  }
`;
const GameDetail = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 1rem;
  span {
    margin-top: 0.5rem;
    color: #9d9d9d;
  }
`;
const ReviewContainer = styled.form``;

const InputContainer = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
`;
const InputBox = styled.input`
  width: 10.25rem;
  height: 2.25rem;
  padding: 1rem;
  border: none;
  border-radius: 4px;
  background-color: #f5f5f5;
  ::placeholder {
    text-align: center;
    font-size: 0.75rem;
    color: #9e9e9e;
  }
  :focus {
    outline: none;
  }
`;
const TextBox = styled.textarea`
  width: 21.4rem;
  height: 4rem;
  padding: 1rem 1rem;
  border: none;
  border-radius: 4px;
  background-color: #f5f5f5;
  ::placeholder {
    font-size: 0.75rem;
    color: #9e9e9e;
  }
  :focus {
    outline: none;
  }
`;
const BtnBox = styled.div`
  display: flex;
  justify-content: flex-end;
`;
const InputBtn = styled.button`
  font-size: 0.7rem;
  color: #9e9e9e;
`;
const StarTime = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 2rem 1rem 1rem;
  span {
    font-size: 0.9rem;
    color: #9e9e9e;
  }
`;
const StarResult = styled.div`
  img {
    width: 1.2rem;
  }
  display: flex;
  justify-content: space-around;
  width: 7rem;
`;
const CommentBox = styled.div`
  margin: auto 1rem;
  span {
    font-weight: 500;
  }
  p {
    margin-top: 0.5rem;
    color: #9e9e9e;
  }
`;
