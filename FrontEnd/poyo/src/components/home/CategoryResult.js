import styled from "styled-components";
import { COLORS } from "../../constants";

export default function CategoryResult() {
  const shuffle = (arr) => {
    arr.sort(() => Math.random() - 0.5);
  };

  const dummy = [
    {
      id: 1,
      title: "스플렌더",
      category: "카드",
      person: "2인",
      level: "입문자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559254164722-51AHDwGznvL.jpg?format=webp",
    },
    {
      id: 2,
      title: "7 원더스",
      category: "카드",
      person: "2인",
      level: "초급자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559253945470-61dlm9QcXpL.jpg?format=webp",
    },
    {
      id: 3,
      title: "팬데믹",
      category: "협동",
      person: "4인",
      level: "초급자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559254186140-51iNoyxoamL.jpg?format=webp",
    },
    {
      id: 4,
      title: "아줄",
      category: "배치",
      person: "2인",
      level: "입문자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559254200327-61EFZADvURL.jpg?format=webp",
    },
    {
      id: 5,
      title: "패치워크",
      category: "배치",
      person: "2인",
      level: "입문자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559254997949-61iejxLClRL.jpg?format=webp",
    },
    {
      id: 6,
      title: "산토리니",
      category: "배치",
      person: "2인",
      level: "입문자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559256777811-61knMbWuqJL.jpg?format=webp",
    },
    {
      id: 7,
      title: "글룸헤이븐",
      category: "롤플레잉",
      person: "2인",
      level: "중급자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559254920151-51ulRXlJ7LL.jpg?format=webp",
    },
    {
      id: 8,
      title: "레이스 포 더 갤럭시",
      category: "빌딩",
      person: "4인",
      level: "중급자",
      image: "https://m.media-amazon.com/images/I/51NTvl7PXgL.jpg",
    },
    {
      id: 9,
      title: "그레이트 웨스턴 트레일",
      category: "빌딩",
      person: "4인",
      level: "고급자",
      image:
        "https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1559254200326-51nQKg6k7DL.jpg?format=webp",
    },
  ];

  shuffle(dummy);

  return (
    <>
      <List>
        {dummy.map((v) => {
          return (
            <Item key={v.id}>
              <a href="/detail">
                <span>{v.title}</span>
                <img src={v.image} alt={v.title} />
              </a>
            </Item>
          );
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
