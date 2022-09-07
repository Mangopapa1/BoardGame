import styled from "styled-components";
import { COLORS } from "../../constants";

export default function Splash () {
    return (
        <>
        <SplashWrap>
        <Logo src="img/logo.svg" alt="메인로고" />
        </SplashWrap>
        </>
    )
}

const SplashWrap = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: ${COLORS.main}
`;
const Logo = styled.img`
`;