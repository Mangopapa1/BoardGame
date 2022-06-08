import SearchInput from "./SearchInput";
import styled from "styled-components";
import Category from "./Category";

export default function Home() {
  return (
    <>
      <Logo src="img/logo.svg" alt="" />
      <SearchInput />
      <Category />
    </>
  );
}

const Logo = styled.img`
  display: block;
  margin: 166px auto 40px;
`;
