import styled from "styled-components";
import { COLORS } from "../../constants";

export default function ListItem({
  item,
  index,
  handleClick,
  isSelected,
  category,
}) {

  return (
    <>
      <Item onClick={(e) => handleClick(e, index)}>
        {item.type && (
          <button
            className={isSelected && category === item.type ? "show" : ""}
            value={item.type}
          >
            {item.type}
          </button>
        )}
        {item.player && (
          <button
            className={isSelected && category === item.player ? "show" : ""}
            value={item.player}
          >
            {item.player}
          </button>
        )}
        {item.difficulty && (
          <button
            className={isSelected && category === item.difficulty ? "show" : ""}
            value={item.difficulty}
          >
            {item.difficulty}
          </button>
        )}
      </Item>
    </>
  );
}

const Item = styled.li`
  width: fit-content;
  height: fit-content;
  button {
    padding: 0.6rem;
    border: 0.12rem solid ${COLORS.light_gray};
    border-radius: 0.5rem;
    font-size: 0.9rem;
    text-align: center;
  }
  .show {
    border: 0.12rem solid ${COLORS.main};
    background: ${COLORS.main};
  }
`;