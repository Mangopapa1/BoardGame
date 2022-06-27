import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import GameContent from "./GameContent";

export default function DetailPage() {
  const navigate = useNavigate();
  return (
    <>
      <Container>
        <BackBtn onClick={()=> { navigate(-1) }}></BackBtn>
       <GameContent />
        <YoutubeBtn href="https://www.youtube.com/results?search_query=스플렌더" target={'_blank'}>Go to Youtube</YoutubeBtn>
      </Container>
    </>
  );
}
const Container = styled.div`
  width: calc(100% - 3rem);
  margin: 0 auto;
  padding: 2rem 0;
`;
const BackBtn = styled.div`
  width: 1.5rem;
  height: 1.3rem;
  background-image: url(../img/back.svg);
`;

const YoutubeBtn = styled.a`
  display: block;
  width: 20rem;
  height: 3rem;
  margin: 0 auto;
  border: none;
  border-radius: 9px;
  background: #FFD75F;
  text-align: center;
  line-height: 3rem;
`
