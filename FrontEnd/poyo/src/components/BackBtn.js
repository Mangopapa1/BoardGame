import { useNavigate } from "react-router-dom";
import styled from "styled-components";

export const BackButton = () => {
  const navigate = useNavigate();

  return (
    <button onClick={() => navigate("/")}>
      <ArrowBackIcon src="/img/back.svg" />
    </button>
  );
};

const ArrowBackIcon = styled.img`
  position: fixed;
  margin: 1.7rem 1.5rem 1.2rem;
  width: 20px;
  height: 20px;
`;
