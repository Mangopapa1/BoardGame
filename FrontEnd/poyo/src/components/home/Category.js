import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import styled from "styled-components";
import { API, COLORS } from "../../constants";
import ListItem from "./CategoryItem";
import CategoryResult from "./CategoryResult";

export default function Category() {
  const categoryDummy = [
    {
      id: 1,
      category: "미스테리",
    },
    {
      id: 2,
      category: "전략",
    },
    {
      id: 3,
      category: "카드",
    },
    {
      id: 4,
      category: "범죄",
    },
    {
      id: 5,
      category: "타일",
    },
    {
      id: 6,
      category: "추리",
    },
  ];

  const personDummy = [
    {
      id: 1,
      person: "1인",
    },
    {
      id: 2,
      person: "2인",
    },
    {
      id: 3,
      person: "3인",
    },
    {
      id: 4,
      person: "4인",
    },
    {
      id: 5,
      person: "5인",
    },
    {
      id: 6,
      person: "6인 이상",
    },
  ];

  const levelDummy = [
    {
      id: 1,
      level: "입문자",
    },
    {
      id: 2,
      level: "초급자",
    },
    {
      id: 3,
      level: "중급자",
    },
    {
      id: 4,
      level: "상급자",
    },
  ];

  const [isSelect, setIsSelect] = useState(false);
  const [category, setCategory] = useState();

  const handleClick = (e, idx) => {
    setCategory(e.target.value);
    const categoryArr = Array(categoryGame.length).fill(false);
    categoryArr[idx] = true;
    setIsSelect(categoryArr);
  };

  const [categoryGame, setCategoryGame] = useState([
    {
      description: "",
      difficulty: "",
      image: null,
      name: "",
      playTime: "",
      minPlayer: 0,
      maxPlayer: 0,
      type: "",
    }
  ])

  const getGame = async () => {
    const res = await axios.get(`${API}/games`, {
      headers: {
        "Content-type": "application/json",
      },
    });
    setCategoryGame(res.data)
  }

  const categoryArr = []

  categoryGame.map((item, index) => {
    const type = item.type
    if (type.includes(",")) {
      const typeSplit = type.split(',')
      typeSplit.forEach(type => categoryArr.push(type))
    } else categoryArr.push(item.type)
  })

  const set = new Set(categoryArr)

  const setCategoryArr = [...set]

  const newArr = []

  setCategoryArr.map((item, index) => {
    return newArr.push({ type: item })
  })

  useEffect(() => {
    getGame()
  }, [])

  return (
    <>
      <CategoryList>
        <List className="category">
          {newArr.map((item, index) => {
            return (
              <ListItem
                key={index}
                item={item}
                index={index}
                handleClick={handleClick}
                isSelected={isSelect[index]}
                category={category}
              />
            );
          })}
        </List>
        <Line />
        <List className="person">
          {personDummy.map((item, index) => {
            return (
              <ListItem
                key={item.id}
                item={item}
                index={index}
                handleClick={handleClick}
                isSelected={isSelect[index]}
                category={category}
              />
            );
          })}
        </List>
        <Line />
        <List className="level">
          {levelDummy.map((item, index) => {
            return (
              <ListItem
                key={item.id}
                item={item}
                index={index}
                handleClick={handleClick}
                isSelected={isSelect[index]}
                category={category}
              />
            );
          })}
        </List>
      </CategoryList>
      {category && <CategoryResult item={categoryGame} category={category} />}
    </>
  );
}

const CategoryList = styled.div`
  display: flex;
  gap: 1.8rem;
  margin: 0.5rem auto;
  width: calc(100% - 3.5rem);
  overflow: hidden;
  overflow-x: scroll;
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    height: 6px;
    display: none;
  }
  &::-webkit-scrollbar-thumb {
    border-radius: 15px;
    background: ${COLORS.light_gray};
  }
  &::-webkit-scrollbar-track {
    background-color: #fbffff;
  }
  .category {
    min-width: 24.7rem;
  }
  .person {
    min-width: 13rem;
  }
  .level {
    min-width: 10rem;
  }
`;

const List = styled.ul`
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  /* min-width: 25.5rem; */
  /* min-width: fit-content; */
  color: ${COLORS.gray};
`;

const Line = styled.div`
  border-left: 0.12rem solid ${COLORS.light_gray};
`;