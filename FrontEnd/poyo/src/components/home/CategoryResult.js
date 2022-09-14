import styled from "styled-components";
import { COLORS } from "../../constants";

export default function CategoryResult({ item, category }) {

  const shuffle = (arr) => {
    arr.sort(() => Math.random() - 0.5);
  };

  return (
    <>
      <List>
        {item.map((v, i) => {
          if (v.type.includes(category)) {
            return (
              <Item key={i}>
                <a href="/detail">
                  <span>{v.name}</span>
                  <img src={v.image} alt={v.title} />
                </a>
              </Item>
            )
          } else if (v.difficulty.includes(category)) {
            return (
              <Item key={i}>
                <a href="/detail">
                  <span>{v.name}</span>
                  <img src={v.image} alt={v.title} />
                </a>
              </Item>
            )
          } else {
            if (v.minPlayer <= category.split("")[0] && v.maxPlayer >= category.split("")[0]) {
              return (
                <Item key={i}>
                  <a href="/detail">
                    <span>{v.name}</span>
                    <img src={v.image} alt={v.title} />
                  </a>
                </Item>
              )
            }
          }
        })}
      </List>
    </>
  );
}

const List = styled.ul`
  display: flex;
  gap: 0.75rem;
  margin: 1.75rem auto;
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
    background-color: #fff;
  }
`;

const Item = styled.li`
  position: relative;
  a {
    display: block;
    border-radius: 0.5rem;
    &::before {
      content: "";
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      border-radius: 0.5rem;
      background: linear-gradient(
        180deg,
        rgba(255, 255, 255, 0.1),
        70%,
        rgba(0, 0, 0, 0.6)
      );
    }
  }
  span {
    position: absolute;
    bottom: 0.5rem;
    left: 0.5rem;
    padding: 0 0.3rem 0 0;
    font-size: 0.75rem;
    font-weight: 700;
    line-height: 0.9rem;
    color: ${COLORS.white};
  }
  img {
    width: 88px;
    height: 88px;
    border-radius: 0.5rem;
    vertical-align: top;
    object-fit: cover;
  }
`;