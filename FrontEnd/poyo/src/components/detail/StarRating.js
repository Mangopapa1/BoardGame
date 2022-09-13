import { useState } from "react";
import styled from "styled-components";

export default function StarRating() {
  const [clicked, setClicked] = useState([false, false, false, false, false]);

  const clickStar = (index) => {
    let starState = [...clicked];
    for (let i = 0; i < 5; i++) {
      starState[i] = i <= index ? true : false;
    }
    setClicked(starState);
  };

  let score = clicked.filter(Boolean).length;

  console.log(clicked);
  return (
    <RatingBox>
      <StarBox>
        {[0, 1, 2, 3, 4].map((el, i) => {
          return (
            <i
              key={i}
              onClick={() => {
                clickStar(el);
              }}
              className={clicked[el]? "yellowStar":""}
            />
          );
        })}
      </StarBox>
      <span>{score}.0</span>
    </RatingBox>
  );
}

const RatingBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 7rem;
  margin: 1rem 0;
  text-align: center;
  span {
    display: block;
    margin-top: 1rem;
    font-weight: 500;
    color: #9e9e9e;
  }
`;
const StarBox = styled.div`
  i {
    width: 1.75rem;
    height: 1.75rem;
    background: url("/img/starempty.svg") no-repeat center;
    cursor: pointer;
  }
  .yellowStar {
    background: url("/img/star.svg") no-repeat center;
  }
  display: flex;
  justify-content: space-around;
  width: 11.3rem;
  margin: 0 auto;
`;
