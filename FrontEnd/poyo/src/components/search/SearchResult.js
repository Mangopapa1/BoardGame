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
      image:
        "https://image.ytn.co.kr/general/jpg/2021/0311/202103110915014429_d.jpg",
      word: location.state + " 맨션 (Suspects)",
    },
    {
      id: 2,
      image: "https://dimg.donga.com/wps/NEWS/IMAGE/2010/06/25/29410677.1.jpg",
      word: location.state + " 사건 사고",
    },
    {
      id: 3,
      image:
        "https://www.theguru.co.kr/data/photos/20210310/art_16152560003284_ac2b0e.jpg",
      word: location.state + " 블로그",
    },
    {
      id: 4,
      image:
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGQgQgO17Fge1x1EwPp1JnjINvfFdpyeVe2A&usqp=CAU",
      word: location.state + " 불가사의",
    },
    {
      id: 5,
      image: "https://pbs.twimg.com/media/FPepTVraAAIDjfW.png:small",
      word: location.state + " 캔디",
    },
    {
      id: 6,
      image: "https://cdn.techm.kr/news/photo/202012/78574_74356_3753.jpg",
      word: location.state + " 부루마블",
    },
    {
      id: 7,
      image:
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQy-5cbYm9I0ALWYcykasXaGjYYJ2npSJcI4MZQGAQgdp7Io2fTD9TqPlnq6LEl4iAiuoY&usqp=CAU",
      word: location.state + " 산장의 기억",
    },
    {
      id: 8,
      image:
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStoWlSfskVeITb1LyAuQCauH9MpeI79RZE5A&usqp=CAU",
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
            <SearchList key={v.id}>
              <Link to={`/detail`}>
                <img src={v.image} alt="" />
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
    width: 3.4rem;
    height: 3.4rem;
    border-radius: 0.5rem;
    object-fit: cover;
  }
  span {
    display: block;
    padding: 1.3rem 0;
    width: 100%;
  }
`;
