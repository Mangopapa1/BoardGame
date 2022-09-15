import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import styled from "styled-components";
import { API, COLORS } from "../../constants";
import ListItem from "./CategoryItem";
import CategoryResult from "./CategoryResult";

export default function Category() {

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
  const difficultyArr = []

  categoryGame.map((item, index) => {
    const type = item.type
    if (type.includes(",")) {
      const typeSplit = type.split(',')
      typeSplit.forEach(type => categoryArr.push(type))
    } else categoryArr.push(item.type)

    const difficulty = item.difficulty
    difficultyArr.push(difficulty)
  })

  const newSetCategory = new Set(categoryArr)
  const newSetDifficulty = new Set(difficultyArr)

  const setCategoryArr = [...newSetCategory]
  const setDifficultyArr = [...newSetDifficulty]
  const setPlayerArr = [1, 2, 3, 4, 5, 6]

  const difficultyItem = setDifficultyArr.splice(0, 1)
  setDifficultyArr.splice(2, 0, difficultyItem[0])

  const newCategoryArr = []
  const newDifficultyArr = []
  const newPlayerArr = []

  setCategoryArr.map((item, index) => {
    return newCategoryArr.push({ type: item })
  })

  setDifficultyArr.map((item, index) => {
    return newDifficultyArr.push({ difficulty: item })
  })

  setPlayerArr.map((item, index) => {
    if (item >= 6) {
      newPlayerArr.push({ player: item + `인 이상` })
    } else newPlayerArr.push({ player: item + `인` })
  })

  useEffect(() => {
    getGame()
  }, [])

  return (
    <>
      <CategoryList>
        <List className="category">
          {newCategoryArr.map((item, index) => {
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
          {newPlayerArr.map((item, index) => {
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
        <List className="level">
          {newDifficultyArr.map((item, index) => {
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