import { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { COLORS } from "../../constants";
import PopularSearch from "./PopularSearch";

export default function SearchInput() {


  const navigate = useNavigate()

  const [search, setSearch] = useState("")



  const onChangeSearch = (e) => {
    e.preventDefault()
    setSearch(e.target.value)
  }

  console.log(search);

  const onSubmit = (e) => {
    e.preventDefault()
    navigate(`/search/${search}`, { state: search })
  }

  return (
    <>
      <Form onSubmit={onSubmit}>
        <Label htmlFor="search">
          <SearchInp id="search" type="text" placeholder="Search" value={search} onChange={onChangeSearch} />
          <button type="submit"></button>
        </Label>
      </Form>
      <PopularSearch />
    </>
  );
}

const Form = styled.form`
  margin: 0 auto;
  width: calc(100% - 3rem);
`;

const Label = styled.label`
  position: relative;
  &::before {
    content: "";
    position: absolute;
    top: 50%;
    transform: translate(50%, -50%);
    width: 1.5rem;
    height: 1.5rem;
    background: url("/img/search.svg") no-repeat center;
  }
  button {
    display: none;
  }
`;

const SearchInp = styled.input`
  display: block;
  padding: 0.4rem 1rem 0.4rem 3rem;
  width: 100%;
  height: 3.125rem;
  border: none;
  border-radius: 0.5rem;
  background: ${COLORS.light_white};
  color: ${COLORS.black};
  &:focus {
    outline: none;
  }
  &::placeholder {
    color: ${COLORS.gray};
  }
`;
