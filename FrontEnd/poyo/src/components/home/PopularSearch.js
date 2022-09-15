import styled from "styled-components";
import { COLORS } from "../../constants";

export default function PopularSearch() {
  const dummy = [
    // {
    //   id: 1,
    //   word: "오늘의 추천",
    // },
    // {
    //   id: 2,
    //   word: "소설",
    // },
    // {
    //   id: 3,
    //   word: "카드",
    // },
    // {
    //   id: 4,
    //   word: "범죄",
    // },
    // {
    //   id: 5,
    //   word: "어린이",
    // },
    // {
    //   id: 6,
    //   word: "추리",
    // },
    // {
    //   id: 7,
    //   word: "건물",
    // },
    // {
    //   id: 8,
    //   word: "주사위",
    // },
    // {
    //   id: 9,
    //   word: "술",
    // },
  ];

  return (
    <>
      <WordList>
        {/* {dummy.map((v) => {
          return (
            <Word key={v.id}>
              <p>
                {v.id}. {v.word}
              </p>
            </Word>
          );
        })} */}
      </WordList>
    </>
  );
}

const WordList = styled.ul`
  display: flex;
  gap: 0.5rem;
  margin: 1.2rem auto 0;
  width: calc(100% - 3.5rem);
  color: ${COLORS.gray};
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

const Word = styled.li`
  p {
    padding: 0.5rem 0 1rem;
    width: 4.4rem;
    font-size: 0.9rem;
    text-align: center;
    cursor: pointer;
  }
`;
