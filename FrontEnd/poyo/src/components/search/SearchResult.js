import axios from "axios";
import { useEffect, useState } from "react";
import { useLocation, useNavigate, Link } from "react-router-dom";
import styled from "styled-components";
import { API, COLORS } from "../../constants";

export default function SearchResult() {
  const location = useLocation();

  const navigate = useNavigate();

  const [game, setGame] = useState(location.state.game)

  const getGameSearch = async () => {
    const res = await axios.get(`${API}/search/name/${search}`, {
      headers: {
        "Content-type": "application/json",
      },
    });
    setGame(res.data)
  }

  const [search, setSearch] = useState(location.state.search);

  const onChangeSearch = (e) => {
    e.preventDefault();
    setSearch(e.target.value);
  };

  const onSubmit = (e) => {
    e.preventDefault();
    navigate(`/search/${search}`, {
      state: {
        search: search,
        game: game
      }
    });
  };

  useEffect(() => {
    getGameSearch()
  }, [search]);

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
        {game.map((v) => {
          return (
            <SearchList key={v.id}>
              <Link to={`/detail`}>
                <img src={v.image} alt="" />
                <span>{v.name}</span>
              </Link>
            </SearchList>
          );
        })}
      </ul>
    </>
  );
}

const Form = styled.form`
  margin: 4.4rem auto 1.5rem;
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
  padding: 0 0 0.5rem;
  margin: 0.7rem auto 1.2rem;
  width: calc(100% - 3.7rem);
  font-size: 0.92rem;
  /* border-bottom: 0.05rem solid ${COLORS.light_gray}; */
  a {
    display: flex;
    align-items: center;
    gap: 1rem;
  }
  img {
    width: 3.5rem;
    height: 3.5rem;
    border-radius: 0.5rem;
    object-fit: cover;
    border: 1px solid black;
  }
  span {
    display: block;
    padding: 1.3rem 0;
    width: 100%;
  }
`;
