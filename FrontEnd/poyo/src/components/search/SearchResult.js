import { useState } from "react";
import { useLocation, useNavigate, Link } from "react-router-dom";
import styled from "styled-components";
import { COLORS } from "../../constants";

export default function SearchResult() {
  const location = useLocation();

  const navigate = useNavigate();

  const [search, setSearch] = useState(location.state);
  const onChangeSearch = (e) => {
    e.preventDefault();
    setSearch(e.target.value);
  };

  const searchDummy = [
    {
      id: 1,
      word: location.state + " 맨션 (Suspects)",
    },
    {
      id: 2,
      word: location.state + " 사건 사고",
    },
    {
      id: 3,
      word: location.state + " 블로그",
    },
    {
      id: 4,
      word: location.state + " 불가사의",
    },
    {
      id: 5,
      word: location.state + " 캔디",
    },
    {
      id: 6,
      word: location.state + " 부루마블",
    },
    {
      id: 7,
      word: location.state + " 산장의 기억",
    },
    {
      id: 8,
      word: location.state + " 오레오",
    },
  ];

  const onSubmit = (e) => {
    e.preventDefault();
    navigate(`/search/${search}`, { state: search });
  };

  return (
    <>
      <Form onSubmit={onSubmit}>
        <Label htmlFor="search">
          <SearchInp
            id="search"
            type="text"
            placeholder="Search"
            value={search}
            onChange={onChangeSearch}
          />
          <button type="submit"></button>
        </Label>
      </Form>
      <ul>
        {searchDummy.map((v) => {
          return (
            <SearchList>
              <Link to={`/detail`}>
                <span>{v.word}</span>
              </Link>
            </SearchList>
          );
        })}
      </ul>
    </>
  );
}

const Form = styled.form`
  margin: 4.4rem auto 1.2rem;
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

const SearchList = styled.li`
  margin: 0.7rem auto;
  width: calc(100% - 3.7rem);
  font-size: 0.92rem;
  span {
    display: block;
    padding: 1.3rem 0;
    width: 100%;
  }
`;
