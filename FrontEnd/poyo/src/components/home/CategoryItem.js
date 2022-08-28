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
        {item.person && (
          <button
            className={isSelected && category === item.person ? "show" : ""}
            value={item.person}
          >
            {item.person}
          </button>
        )}
        {item.level && (
          <button
            className={isSelected && category === item.level ? "show" : ""}
            value={item.level}
          >
            {item.level}
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